package com.lzp.springboot.testSwing;

import javax.swing.*;

/**
 * 测试登录框
 *
 * @authorHmLzp
 * @create 2019 - 02 - 10 21:59
 */
public class TestLogin {

    private static void placeComponents(JPanel jPanel) {
        /**
         * 设置布局为  null
         */

        jPanel.setLayout(null);

        //创建 JLabel
        JLabel userLable = new JLabel("User:");
        /**
         * 这个方法 定义了 组件的位置
         * setBounds(x,y,width,heoght)
         * x 和 y 指定左上角的新位置，有 width 和 height指定新的大小
         */
        userLable.setBounds(10,20,80,25);
        jPanel.add(userLable);

        /**
         * 创建文本域 用于用户输入
         *
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        jPanel.add(userText);

        //创建输入密码的文本域
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        jPanel.add(passwordLabel);
        /**
         * 这个类似用于输入的文本域
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        jPanel.add(passwordText);

        //创建登录按钮
        JButton button = new JButton("登   录");
        button.setBounds(10,80,80,25);
        jPanel.add(button);

    }

    public static void main(String[] args) {
        //创建JFrame实例
        JFrame frame = new JFrame("Login Example");

        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * 创建面板 这个类似HTML 的 div 标签
         * 我们可以创建多个面板并在JFrame中指定指定位置
         * 面板中我们可以添加 文本字段， 按钮及其他组件
         */
        JPanel jPanel = new JPanel();
        frame.add(jPanel);
        /**
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(jPanel);

        //设置界面是可见
        frame.setVisible(true);
    }
}
