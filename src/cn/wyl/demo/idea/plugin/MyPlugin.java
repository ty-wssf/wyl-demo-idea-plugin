package cn.wyl.demo.idea.plugin;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.MessageType;

/**
 * 编写点击菜单的通知内容
 * 通过Pulgins Devkit创建的action继承了Ananction
 *
 * @author wyl
 * @since 2021-11-02 10:38:06
 */
public class MyPlugin extends AnAction {

    /**
     * 需要实现点击事件发生之后的抽象方法
     */
    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        NotificationGroup notificationGroup = new NotificationGroup("testid", NotificationDisplayType.BALLOON, false);
        /**
         * content :  通知内容
         * type  ：通知的类型，warning,info,error
         */
        Notification notification = notificationGroup.createNotification("测试通知", MessageType.INFO);
        Notifications.Bus.notify(notification);
    }
}
