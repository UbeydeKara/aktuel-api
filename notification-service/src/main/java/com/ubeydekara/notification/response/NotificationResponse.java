package com.ubeydekara.notification.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationResponse {
    private List<Data> data;

    @AllArgsConstructor
    @NoArgsConstructor
    @lombok.Data
    public static class Data {
        // device token
        private String id;

        private String status;
        private String message;

        // if status === error
        @AllArgsConstructor
        @NoArgsConstructor
        @lombok.Data
        public static class Details {
            private String error;
        }
    }
}
