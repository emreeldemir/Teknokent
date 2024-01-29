public class LinkedInNotification extends NotificationDecorator {

    Notification notification;

    public LinkedInNotification(Notification notification) {
        this.notification = notification;
    }

    @Override
    public String getNotify() {
        return  notification.getNotify() + getDecoratorNotify();
    }

    @Override
    public String getMessage() {
        return notification.getMessage();
    }

    @Override
    public String getDecoratorNotify() {
        return "\n LinkedIn Notify : " + notification.getMessage();
    }
}
