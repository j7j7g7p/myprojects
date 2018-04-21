package com.test;

import java.awt.Toolkit;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;

public class QQMOVE {

    public static void main(String[] args) throws InterruptedException {
        test1();
        // test2();
    }
    
    
    

    public static void test1() throws InterruptedException {
        // 在Windows中，User32.dll文件拥有大量的操作用户界面的API。可以看到JNA在包命名上也遵照了DLL的命名规律。
        // 第一个参数是Windows窗体的窗体类，第二个参数是窗体的标题。不熟悉windows编程的需要先找一些Windows窗体数据结构的知识来看看，还有windows消息循环处理，其他的东西不用看太多。
        HWND hwnd = User32.INSTANCE.FindWindow(null, "QQ");
        if (hwnd == null) {
            System.out.println("QQ is not running");
        } else {
            User32.INSTANCE.ShowWindow(hwnd, 9); // SW_RESTORE
            User32.INSTANCE.SetForegroundWindow(hwnd); // bring to front

            // User32.INSTANCE.GetForegroundWindow(); //获取现在前台窗口
            WinDef.RECT qqwin_rect = new WinDef.RECT();
            User32.INSTANCE.GetWindowRect(hwnd, qqwin_rect);
            int qqwin_width = qqwin_rect.right - qqwin_rect.left;
            int qqwin_height = qqwin_rect.bottom - qqwin_rect.top;

            User32.INSTANCE.MoveWindow(hwnd, 10, -1, qqwin_width, qqwin_height, true);

            double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth() - qqwin_width;
            
//            Pointer pointer = qqwin_rect.getPointer();
//            int size = qqwin_rect.size();
//            int size1 = qqwin_rect.ALIGN_DEFAULT;
//            int size2 = qqwin_rect.ALIGN_GNUC;
//            int size3 = qqwin_rect.ALIGN_MSVC;
//            int size4 = qqwin_rect.ALIGN_NONE;
            
            System.out.println();
            for (int i = 0; i <= width; i += 10) {
                User32.INSTANCE.MoveWindow(hwnd, i, -1, qqwin_width, qqwin_height, true);
                Thread.sleep(80);
            }

             test2();

             //User32.INSTANCE.PostMessage(hwnd, WinUser.WM_CLOSE, null, null);
        }
    }


    static WinUser.INPUT input = new WinUser.INPUT();

    public static void test2() {
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow(null, "QQ");
        // 第一个参数是Windows窗体的窗体类，第二个参数是窗体的标题。不熟悉windows编程的需要先找一些Windows窗体数据结构的知识来看看，还有windows消息循环处理，其他的东西不用看太多。
        if (hwnd == null) {
            System.out.println("QQ is not running");
        } else {
            User32.INSTANCE.ShowWindow(hwnd, 9); // SW_RESTORE
            User32.INSTANCE.SetForegroundWindow(hwnd); // bring to front

            String fillWord = "my frend 69671710 wan";
            for (Character c : fillWord.toCharArray())
                sendChar(c);
        }
    }

    static void sendChar(char ch) {

        input.type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
        input.input.setType("ki"); // Because setting INPUT_INPUT_KEYBOARD is not enough:
                                   // https://groups.google.com/d/msg/jna-users/NDBGwC1VZbU/cjYCQ1CjBwAJ
        input.input.ki.wScan = new WinDef.WORD(0);
        input.input.ki.time = new WinDef.DWORD(0);
        input.input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
        // Press
        input.input.ki.wVk = new WinDef.WORD(Character.toUpperCase(ch)); // 0x41
        input.input.ki.dwFlags = new WinDef.DWORD(0); // keydown

        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());
        // Release
        input.input.ki.wVk = new WinDef.WORD(Character.toUpperCase(ch)); // 0x41
        input.input.ki.dwFlags = new WinDef.DWORD(2); // keyup
        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());
    }
}
