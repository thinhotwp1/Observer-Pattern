/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observerpatternsample.service;

import java.util.Observable;
import java.util.Observer;

import observerpatternsample.channel.YoutubeChannel;
import observerpatternsample.model.VideoUpload;

/**
 * @author Administrator
 */
public class Subscriber implements Notification, Observer {

    private String titleGmail;
    private String gmailMessage;
    private String channelName;
    Observable observable;

    public Subscriber(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        // Xử lý youtube channel
        if (o instanceof YoutubeChannel youtubeChannel) {
            // get info from channel
            VideoUpload videoUpload = youtubeChannel.getVideoUpload();
            this.channelName = "Thông báo từ channel: " + youtubeChannel.getNameChannel();
            this.titleGmail = "Video mới: " + videoUpload.getNameVideo();
            this.gmailMessage = "Mô tả: " + videoUpload.getDescriptionVideo() + ", thời gian đăng: " + videoUpload.getTimeUpload();
            sendToSubscriber();
        }
        // Có thể thêm với tiktok channel, instagram,...
    }

    @Override
    public void sendToSubscriber() {
        System.out.println(this.channelName);
        System.out.println(this.titleGmail);
        System.out.println(this.gmailMessage);
        // do something else, update object, ...
    }
}
