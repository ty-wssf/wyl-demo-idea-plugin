# Idea插件开发-开发自己的第一款idea插件

## 使用DevKit插件开发流程

1. 搭建开发环境
2. 创建一个插件项目
3. **创建动作**(插件具体内容的开发)
4. 运行和调试插件
5. 部署插件
6. 发布插件

## 环境准备

1. 安装IDEA
2. 在IDEA中**Plugin DevKit**，为开发IDEA插件提供支持
3. 配置**IntelliJ Platform Plugin SDK**

## 创建一个插件项目

1. file->new Project

   ![img](https://gitee.com/wuyilong/picture-bed/raw/master//img/1717cd8991fb0697~tplv-t2oaga2asx-watermark.awebp)

2. 填写工程名称

   ![img](https://gitee.com/wuyilong/picture-bed/raw/master//img/1717cd95b8569e69~tplv-t2oaga2asx-watermark.awebp)

3. 工程创建成功，工程目录如下，plugin.xml是核心配置文件

   ![img](https://gitee.com/wuyilong/picture-bed/raw/master//img/1717cd9a94990565~tplv-t2oaga2asx-watermark.awebp)

4. 核心配置文件说明

```xml
<idea-plugin>
    
  <!-- 插件唯一id，不能和其他插件项目重复，所以推荐使用com.xxx.xxx的格式
       插件不同版本之间不能更改，若没有指定，则与插件名称相同 -->
  <id>com.your.company.unique.plugin.id</id>
   
  <!-- 插件名称，别人在官方插件库搜索你的插件时使用的名称 -->
  <name>Plugin display name here</name>
  
  <!-- 插件版本号 -->
  <version>1.0</version>
    
  <!-- 供应商主页和email（不能使用默认值，必须修改成自己的）-->
  <vendor email="support@yourcompany.com" url="http://www.yourcompany.com">YourCompany</vendor>
  <!-- 插件的描述 （不能使用默认值，必须修改成自己的。并且需要大于40个字符）-->
  <description><![CDATA[
      Enter short description for your plugin here.<br>
      <em>most HTML tags may be used</em>
    ]]></description>
  <!-- 插件版本变更信息，支持HTML标签；
       将展示在 settings | Plugins 对话框和插件仓库的Web页面 -->
  <change-notes><![CDATA[
      Add change notes here.<br>
      <em>most HTML tags may be used</em>
    ]]>
  </change-notes>

 <!-- 插件兼容IDEAbuild 号-->
  <idea-version since-build="173.0"/>

  <!-- 插件所依赖的其他插件的id -->
  <depends>com.intellij.modules.platform</depends>

  <extensions defaultExtensionNs="com.intellij">
  <!-- 声明该插件对IDEA core或其他插件的扩展 -->
  </extensions>

  <!-- 编写插件动作 -->
  <actions>
  </actions>

</idea-plugin>
```

## 创建一个动作action

1. 创建action

   ![img](https://gitee.com/wuyilong/picture-bed/raw/master//img/1717cda074f7f54d~tplv-t2oaga2asx-watermark.awebp)

2. 填写相关参数

   - ① action的基本信息，其中Name属性的值作为将来菜单的文本内容

   - ② 作为Tools菜单下的子菜单

   - ③ 子菜单位置放在第一个

   - ④ 为子菜单添加快捷键

     ![img](https://gitee.com/wuyilong/picture-bed/raw/master//img/1717cda7d4a70ccf~tplv-t2oaga2asx-watermark.awebp)

3. 编写点击菜单的通知内容

   ```xml
   /**
    * 通过Pulgins Devkit创建的action继承了Ananction
    *
    */
   public class TestAction extends AnAction {
   
   
       /**
        * 需要实现点击事件发生之后的抽象方法
        */
       @Override
       public void actionPerformed(AnActionEvent e) {
           NotificationGroup notificationGroup = new NotificationGroup("testid", NotificationDisplayType.BALLOON, false);
           /**
            * content :  通知内容
            * type  ：通知的类型，warning,info,error
            */
           Notification notification = notificationGroup.createNotification("测试通知", MessageType.INFO);
           Notifications.Bus.notify(notification);
       }
   }
   ```

## 运行和调试插件

1. 和我正常调试java代码一样，也可以在需要的位置打上断点。

   ![img](https://gitee.com/wuyilong/picture-bed/raw/master//img/1717cdb02ccc660e~tplv-t2oaga2asx-watermark.awebp)

2. 运行结果

   ![img](https://gitee.com/wuyilong/picture-bed/raw/master//img/1717cdbed0db3023~tplv-t2oaga2asx-watermark.awebp)

## 部署插件

1. 打包

   ![img](https://gitee.com/wuyilong/picture-bed/raw/master//img/1717cdc1c91650e2~tplv-t2oaga2asx-watermark.awebp)

2. 部署（从硬盘选择安装文件的方式）

   ![img](https://gitee.com/wuyilong/picture-bed/raw/master//img/1717cdc3e08033a3~tplv-t2oaga2asx-watermark.awebp)

## 发布插件

注册idea账号访问[plugins.jetbrains.com/author/me/](https://link.juejin.cn/?target=https%3A%2F%2Fplugins.jetbrains.com%2Fauthor%2Fme%2F)

1. 登录插件库

   ![img](https://gitee.com/wuyilong/picture-bed/raw/master//img/1717cdc73870874d~tplv-t2oaga2asx-watermark.awebp)

2. 选择打包好的插件，进行上传，等待审核结果。一般需要2-3个工作日出结果。如果成功了，别人就可以在线搜索咱们开发的插件了。

   ![img](https://gitee.com/wuyilong/picture-bed/raw/master//img/1717cdd171e88cf9~tplv-t2oaga2asx-watermark.awebp)