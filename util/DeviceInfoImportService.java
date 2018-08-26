import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.base.utils.ParaMap;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.base.ds.DataSourceManager;
import com.base.log.Logging;
import com.base.service.BaseService;
import com.base.utils.DateUtils;
import com.base.utils.FileRoot;
import com.base.utils.StrUtils;
import com.base.web.AppConfig;

public class DeviceInfoImportService extends BaseService {
	Logging log = Logging.getLogging("DeviceInfoImportService");
	private static final String DEFAULT_FONT_NAME = "Microsoft YaHei";
	private static final int DEFAULT_FONT_SIZE = 20 * 12;
	private static final String MONEY_FORMAT = "#,##0.00";

	/**
	 * @param:type:文件后缀名"
	 * @param inMap
	 *            上传的文件流
	 * @param addarr
	 *            文档中的列信息
	 * @param clazz
	 *            调用方法的类
	 * @param addMethod
	 *            插入数据库所调用的方法
	 * @param updateMethod
	 *            更新刚刚插入的记录信息
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	public ParaMap importFile(ParaMap inMap, String[][] addarr, Class<?> clazz, String addMethod, String updateMethod)
			throws Exception {
		log.info("正式开始导入");
		InputStream is = null;
		// 测试用
		// is = new FileInputStream("C:\\Users\\DELL\\Desktop\\特殊卡导入模板.xls");

		byte[] fileContent = inMap.getBytes("content");
		is = new ByteArrayInputStream(fileContent);

		ParaMap outMap = new ParaMap();
		ArrayList<ParaMap> errList = new ArrayList<ParaMap>();

		String type = com.base.utils.StrUtils.trim(inMap.getString("extension"));
		Workbook workbook = "xls".equals(type) ? new HSSFWorkbook(is)
				: "xlsx".equals(type) ? new XSSFWorkbook(is) : null;
		if (workbook == null) {
			outMap.put("state", 2);
			outMap.put("msg", "上传失败-格式错误，请使用 xls格式或者 xlsx格式");
			return outMap;
		}
		Sheet sheet = workbook.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		int total = 0;
		for (int j = 2; j <= rowNum; j++) {// 去掉多余空行
			Row row = sheet.getRow(j);
			boolean blankRow = isBlankRow(row, addarr);
			if (!blankRow) {
				total++;
			}
		}

		int coloumNum = sheet.getRow(1).getPhysicalNumberOfCells();// 获得总列数

		if (coloumNum != addarr.length) {
			outMap.put("state", 2);
			outMap.put("totalnum", rowNum);
			outMap.put("successnum", 0);
			outMap.put("failnum", rowNum);
			ParaMap errMap = new ParaMap();
			errMap.put("msg", "模板出现异常错误，请仔细检查导入模板后重试。");
			errList.add(errMap);
			outMap.put("errlist", errList);
			outMap.put("template", 2);
			// System.out.println(outMap.toString());
			return outMap;
		}
		int successNum = 0;
		int failNum = 0;
		int colIndex = addarr.length;
		Cell cell = null;
		List<ParaMap> addMapList = new ArrayList<ParaMap>();
		Object o = null;
		ParaMap om = null;
		o = clazz.newInstance();
		log.info("开始调用验证");
		Method method = clazz.getMethod(addMethod, ParaMap.class);
		log.info("开始调用导入方法");
		Method method2 = clazz.getDeclaredMethod(updateMethod, ParaMap.class);
		inMap.remove("content");
		for (int i = 1; i <= total; i++) {
			boolean isRowPassNullCheck = true;
			Row row = sheet.getRow(i + 1);
			ParaMap addMap = new ParaMap();
			addMap.putAll(inMap);
			try {

				for (int j = 0; j < addarr.length; j++) {
					String key = addarr[j][0];
					String flag = addarr[j][1];
					String desc = addarr[j][2];
					String str = null;
					cell = row.getCell(j);
					if (cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						str = cell.getStringCellValue();
						if (StrUtils.isNotNull(str)) {
							str = str.trim();
						} else {
							str = "";
						}
						addMap.put(key, str);
					}
					if ("true".equals(flag) && (cell != null) && (StrUtils.isNull(str))) {
						failNum++;
						ParaMap errMap = new ParaMap();
						errMap.put("errrow", i + 2);
						errMap.put("errmsg", desc + "不能为空。");
						errMap.put("msg", "第" + (i + 2) + "行" + "第" + (j + 1) + "列数据出错；原因：" + desc + "不能为空。");
						errList.add(errMap);
						isRowPassNullCheck = false;
						DataSourceManager.rollback();
					}
				}
				if (isRowPassNullCheck && addMap.size() > 0) {
					om = null;
					om = (ParaMap) method.invoke(o, addMap);
					log.info("导入结果,inMap:" + om.toString());
					if (om.getInt("state") == 1) {
						ParaMap updateMap = new ParaMap();
						updateMap.put("creator", "importdata");
						updateMap.put("id", addMap.get("id"));
						updateMap.put("updatetime", DateUtils.nowTime());

						method2.invoke(o, updateMap);
						successNum++;
						addMap.clear();
						DataSourceManager.commit();
						cell = row.createCell(colIndex);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						cell.setCellValue("");
					} else {
						failNum++;
						ParaMap errMap = new ParaMap();
						errMap.put("errrow", "第" + (i + 2) + "行");
						errMap.put("errmsg", om.getString("message"));
						errMap.put("msg", "第" + (i + 2) + "行数据出错；原因：" + om.getString("message"));
						errList.add(errMap);
						DataSourceManager.rollback();
						outMap.put("state", 2);
						outMap.put("resultmessage", om.getString("message"));

						cell = row.createCell(colIndex);
						cell.setCellType(Cell.CELL_TYPE_STRING);
						cell.setCellValue("第" + (i + 2) + "行错误: " + om.getString("message"));
					}
				}
			} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
					| IllegalArgumentException | InvocationTargetException e) {
				log.info("出现异常，信息" + e.toString());
				failNum++;
				errList.clear();
				ParaMap errMap = new ParaMap();
				errMap.put("msg", "出现异常错误，请仔细检查模板数据后重试。");
				errList.add(errMap);
				DataSourceManager.rollback();
			}
			addMapList.add(addMap);
		}
		outMap.put("list", addMapList);
		System.out.println();
		System.out.println(outMap);
		System.out.println();
		outMap.put("totalnum", rowNum);
		outMap.put("successnum", successNum);
		outMap.put("failnum", failNum);
		outMap.put("errlist", errList);
		if (failNum > 0) {
			outMap.put("state", 2);
			outMap.put("msg", "上传失败");

			// 用于测试
			// writeToErrFile(is, workbook);

			/*
			 * 正式
			 */
			String extension = "xls".equals(type) ? ".xls" : ".xlsx";
			String fileName = "importErrorData" + extension;
			String importErrorFile = "imPortErrorFile";

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] buf = null;
			workbook.write(os);
			buf = os.toByteArray();
			os.flush();
			os.close();
			workbook.close();

			File filep = getAppImgFile(importErrorFile, fileName);
			checkFile(filep);
			FileUtils.writeByteArrayToFile(filep, buf);
		} else {
			outMap.put("state", 1);
			outMap.put("msg", "上传成功");
		}
		outMap.put("template", 1);
		return outMap;
	}

	/**
	 * 获取单元格样式
	 * 
	 * @param workbook
	 * @return
	 */
	private static CellStyle getCellStyle(Workbook workbook) throws Exception {
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		return cellStyle;
	}

	public static String getDateStr(Date date) {
		if (date == null) {
			return null;
		}
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * 添加单元格
	 * 
	 * @param workbook
	 * @param sheet
	 * @param rowIndex
	 *            添加的行号
	 * @param inMap
	 */
	private void addCell(String[] fieldNames, Workbook workbook, Sheet sheet, int rowIndex, int recordIndex,
			ParaMap inMap, CellStyle centerColumnStyle, CellStyle moneyColumnStyle) throws Exception {
		Row row = sheet.createRow(rowIndex);
		Cell cellNo = row.createCell(0);
		cellNo.setCellValue(recordIndex);
		cellNo.setCellStyle(centerColumnStyle);
		for (int i = 0; i < fieldNames.length; i++) {
			Cell cell = row.createCell(i + 1);
			String[] names = fieldNames[i].split("-");
			// 设置对齐方式
			if (names.length > 2) {
				cell.setCellValue(inMap.getString(names[0]));
				if ("right".equals(names[1])) {
					cell.setCellStyle(moneyColumnStyle);
				}
			} else if (names.length > 1) {
				cell.setCellValue(inMap.getDouble(names[0]));
				if ("right".equals(names[1])) {
					cell.setCellStyle(moneyColumnStyle);
				}
			} else {
				String value = inMap.getString(names[0]);
				cell.setCellValue(StrUtils.isNull(value) ? "" : value);
				cell.setCellStyle(centerColumnStyle);
			}
		}
	}

	/**
	 * 
	 * @param title 导出的文件名 @param titleColumns 列名称-对应excell列头属性 @param outMap
	 * 数据内容 @param subTitle 子标题 @param recordName 列名称-对应数据库字段名 @return @throws byte
	 */
	public byte[] exportFile(String title, String[] titleColumns, ParaMap outMap, String subTitle, String[] recordName)
			throws Exception {
		int cnt = outMap.getRecordCount();
		long userMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long start = DateUtils.nowTime();
		log.info("导出" + title + "，导出前，占用内存量：" + userMemory / 1024 + " KB，" + userMemory / 1024 / 1024 + " M");
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet(title);
		// 默认字体
		Font defaultFont = workbook.createFont();
		defaultFont.setFontName(DEFAULT_FONT_NAME);
		defaultFont.setFontHeight((short) (DEFAULT_FONT_SIZE));
		// 左对齐样式
		CellStyle leftColumnStyle = getCellStyle(workbook);
		leftColumnStyle.setFont(defaultFont);
		leftColumnStyle.setAlignment((short) HorizontalAlignment.LEFT.ordinal());
		// 中间对齐样式
		CellStyle centerColumnStyle = getCellStyle(workbook);
		centerColumnStyle.setFont(defaultFont);
		centerColumnStyle.setAlignment((short) HorizontalAlignment.CENTER.ordinal());
		// 右对齐样式
		CellStyle rightColumnStyle = getCellStyle(workbook);
		rightColumnStyle.setFont(defaultFont);
		rightColumnStyle.setAlignment((short) HorizontalAlignment.RIGHT.ordinal());
		// 货币样式
		CellStyle moneyColumnStyle = getCellStyle(workbook);
		moneyColumnStyle.setFont(defaultFont);
		DataFormat format = workbook.createDataFormat();
		moneyColumnStyle.setDataFormat(format.getFormat(MONEY_FORMAT));
		moneyColumnStyle.setAlignment((short) HorizontalAlignment.RIGHT.ordinal());
		int rowIndex = 0; // 开始导出的行号
		// 标题
		CellStyle titleStyle = getCellStyle(workbook);
		Font titleFont = workbook.createFont();
		titleFont.setFontName(DEFAULT_FONT_NAME);
		titleFont.setFontHeight((short) (20 * 14));
		titleStyle.setFont(titleFont);
		titleStyle.setAlignment((short) HorizontalAlignment.CENTER.ordinal());
		Row row = sheet.createRow(rowIndex);
		Cell titleCell = row.createCell(0);
		titleCell.setCellStyle(titleStyle);
		titleCell.setCellValue(title);
		// 子标题
		if (StrUtils.isNotNull(subTitle)) {
			rowIndex++;
			Row subRow = sheet.createRow(rowIndex);
			Cell subTitleCell = subRow.createCell(0);
			subTitleCell.setCellStyle(leftColumnStyle);
			subTitleCell.setCellValue(subTitle);
		}
		// 打印时间
		rowIndex++;
		Row subRow2 = sheet.createRow(rowIndex);
		Cell subTitleCell2 = subRow2.createCell(0);
		subTitleCell2.setCellStyle(leftColumnStyle);
		String printTime = "打印时间：" + DateUtils.nowStr();
		subTitleCell2.setCellValue(printTime);
		if (StrUtils.isNotNull(subTitle)) {
			for (int i = 0; i < 3; i++) {
				CellRangeAddress cra = new CellRangeAddress(i, i, 0, titleColumns.length - 1);
				sheet.addMergedRegion(cra);
			}
		} else {
			for (int i = 0; i < 2; i++) {
				CellRangeAddress cra = new CellRangeAddress(i, i, 0, titleColumns.length - 1);
				sheet.addMergedRegion(cra);
			}
		}
		// 设置列名
		rowIndex++;
		Row headerRow = sheet.createRow(rowIndex);
		for (int i = 0; i < titleColumns.length; i++) {
			Cell cell = headerRow.createCell(i);
			String columnName = titleColumns[i];
			String[] str = columnName.split("-");
			// 设置列宽
			sheet.setColumnWidth(i, 256 * (str.length > 1 ? Integer.parseInt(str[1]) : 15));
			cell.setCellValue(str[0]);
			// 设置对其方式
			if (str[0].contains("元") || str[0].contains("金额")) {
				cell.setCellStyle(rightColumnStyle);
			} else {
				cell.setCellStyle(centerColumnStyle);
			}
		}
		for (int i = 0; i < cnt; i++) {
			rowIndex++;
			ParaMap cardListMap = new ParaMap();
			for (int j = 0; j < recordName.length; j++) {
				String str = outMap.getRecordString(i, recordName[j]);
				if (StrUtils.isNotNull(recordName[j]) && recordName[j].contains("time")) {
					str = StrUtils.isNull(str) ? "" : getDateStr(new Date(Long.parseLong(str)));
				}
				cardListMap.put(recordName[j], str);
			}
			addCell(recordName, workbook, sheet, rowIndex, i + 1, cardListMap, centerColumnStyle, moneyColumnStyle);
		}
		// 设置未生成的单元格边框样式
		CellStyle borderStyle = getCellStyle(workbook);
		for (int i = 0; i <= rowIndex; i++) {
			Row r = sheet.getRow(i);
			if (r != null) {
				for (int j = 0; j < titleColumns.length; j++) {
					Cell c = r.getCell(j);
					if (c == null) {
						c = r.createCell(j);
						c.setCellStyle(borderStyle);
					}
				}
			}
		}
		userMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long end = DateUtils.nowTime();
		log.info("导出" + title + "，导出前，占用内存量：" + userMemory / 1024 + " KB，" + userMemory / 1024 / 1024 + " M");
		log.info("导出" + title + "，用时：" + (end - start) + "毫秒");
		String filename = title + "_" + DateUtils.getStr(new Date()).split(" ")[0] + ".xlsx";
		byte[] buf = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		workbook.write(out);
		buf = out.toByteArray();
		out.close();
		workbook.close();
		String userAgent = getRequest().getHeader("USER-AGENT");
		HttpServletResponse response = getResponse();

		if (StrUtils.isNotNull(userAgent) && userAgent.contains("Firefox")) {
			filename = new String(filename.getBytes(), "ISO-8859-1");
		} else {
			filename = URLEncoder.encode(filename, "UTF-8");
		}
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename=" + filename);
		/*
		 * FileOutputStream fout = new FileOutputStream("D:/"+filename);
		 * workbook.write(fout); fout.close();
		 */
		return buf;
	}

	// outputStream转inputStream
	public ByteArrayInputStream OutputStreamParseToInputStream(OutputStream out) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos = (ByteArrayOutputStream) out;
		ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
		return swapStream;
	}

	// 测试用
	public int writeToErrFile(InputStream fis, Workbook workbook) throws IOException {
		FileOutputStream fos = new FileOutputStream("D://luduan1.xlsx");
		byte[] buf = new byte[1024];

		workbook.write(fos);
		fos.write(buf, 0, buf.length);
		fos.flush();
		fos.close();

		return 1;
	}

	public File getAppImgFile(String type, String fileName) {
		String fileId = FileRoot.imgs + "/" + type + "/" + fileName;
		File file = AppConfig.getFile(fileId);
		return file;
	}

	public void checkFile(File file) throws Exception {
		String path = file.getCanonicalPath();
		String fileRoot = AppConfig.getStringPro("fileRoot");
		if (!path.startsWith(fileRoot)) {
			throw new Exception("文件路径非法:" + path);
		}
		FileUtils.forceMkdir(new File(path).getParentFile());
	}

	/**
	 * 判断行是否为空
	 * 
	 * @param row
	 * @return
	 */
	public static boolean isBlankRow(Row row, String[][] addarr) {
		if (row == null) {
			return true;
		}
		boolean result = true;
		short lastCellNum = row.getLastCellNum();
		for (int i = 0; i < lastCellNum; i++) {
			String str = null;
			Cell cell = row.getCell(i);
			if (cell != null) {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				str = cell.getStringCellValue();
			}
			if (StrUtils.isNotNull(str)) {
				return false;
			}
		}
		return result;
	}

	public void testa() {
		System.out.println(super.getClass().getName());
	}

	public ParaMap importSectionInfo(ParaMap inMap) throws Exception {
		ParaMap outMap = new ParaMap();

		if (StrUtils.isNull(inMap.getString("extension"))) {
			outMap.put("state", 2);
			outMap.put("message", "上传的文件类型不能为空!");
			return outMap;
		}
		if (StrUtils.isNull(inMap.getString("comid"))) {
			outMap.put("state", 2);
			outMap.put("message", "管理公司id不能为空！");
			return outMap;
		}

		String[][] addarr = { { "sectioncode", "true", "路段编号" }, { "sectionname", "true", "路段名称" },
				{ "bottomdirectionname", "true", "路段朝向" }, { "cantonname", "true", "行政区名称" },
				{ "areaname", "true", "片区名称" }, { "longitude", "true", "经度" }, { "latitude", "true", "纬度" },
				{ "berthformname", "false", "泊位形式" }, { "distributionname", "false", "泊位分布" },
				{ "workradius", "false", "半径" }, { "memo", "false", "路段备注" }, { "cityname", "true", "城市" } };

		// 导入路段信息数据
		DeviceInfoImportService bs = new DeviceInfoImportService();
		bs.setRequest(getRequest());
		bs.setResponse(getResponse());
		try {
			outMap = bs.importFile(inMap, addarr, BaseService.class, "verifyAndAddSectionInfo", "updateSectionCreator");
			if (outMap.getInt("state", -1) == 1) {
				String logFilename = "路段信息" + "_" + DateUtils.getStr(new Date()).split(" ")[0];
				// 查用户真实姓名
			}
		} catch (Exception e) {
			e.printStackTrace();
			Logging log = Logging.getLogging("SectionService");
			log.info("导入路段异常,massage:" + e.getMessage());
			outMap.put("state", 2);
			outMap.put("message", "导入路段异常");
		}
		return outMap;
	}
}