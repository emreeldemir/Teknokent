public class TeknokentNotification implements Notification {

        private String message;

        public TeknokentNotification(String message) {
            this.message = message;
        }

        @Override
        public String getNotify() {
            return "Teknokent notify : " + getMessage();
        }

        public String getMessage() {
            return message;
        }


}
