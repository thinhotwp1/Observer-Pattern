package observerpatternsample.model;

import java.util.Date;

public class VideoUpload {

    private String nameVideo;
    private String descriptionVideo;
    private Date timeUpload;
    private boolean star;

    public VideoUpload() {
    }

    public VideoUpload(String nameVideo, String descriptionVideo, Date timeUpload, boolean star) {
        this.nameVideo = nameVideo;
        this.descriptionVideo = descriptionVideo;
        this.timeUpload = timeUpload;
        this.star = star;
    }

    public String getNameVideo() {
        return nameVideo;
    }

    public void setNameVideo(String nameVideo) {
        this.nameVideo = nameVideo;
    }

    public String getDescriptionVideo() {
        return descriptionVideo;
    }

    public void setDescriptionVideo(String descriptionVideo) {
        this.descriptionVideo = descriptionVideo;
    }

    public Date getTimeUpload() {
        return timeUpload;
    }

    public void setTimeUpload(Date timeUpload) {
        this.timeUpload = timeUpload;
    }

    public boolean isStar() {
        return star;
    }

    public void setStar(boolean star) {
        this.star = star;
    }
}
