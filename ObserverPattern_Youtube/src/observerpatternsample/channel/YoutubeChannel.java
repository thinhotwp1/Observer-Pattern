/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observerpatternsample.channel;

import observerpatternsample.model.VideoUpload;

import java.util.Observable;

/**
 * Một lớp extends Observable sẽ có thể gửi thông báo tới các Observer(người đăng ký dịch vụ)
 * của lớp đó rằng có sự thay đổi và thực hiện hàm update().
 */
public class YoutubeChannel extends Observable {
    private String nameChannel;
    private VideoUpload videoUpload;

    public YoutubeChannel(String nameChannel) {
        this.nameChannel = nameChannel;
    }

    // constructor
    public void uploadVideo(VideoUpload videoUpload) {
        setVideoUpload(videoUpload);

        // Sau khi upload video, nếu video đánh dấu là star thì sẽ gửi thông báo tới các subscriber.
        if (videoUpload.isStar()) {
            setChanged();
        }
        notifyObservers();
    }

    // get set
    public String getNameChannel() {
        return nameChannel;
    }

    public void setNameChannel(String nameChannel) {
        this.nameChannel = nameChannel;
    }

    public VideoUpload getVideoUpload() {
        return videoUpload;
    }

    public void setVideoUpload(VideoUpload videoUpload) {
        this.videoUpload = videoUpload;
    }
}
