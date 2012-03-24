package org.joensson.nasdvr.model;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;

/**
 * User: frj
 * Date: 3/22/12
 * Time: 9:01 AM
 *
 * @Author frj
 */
@Entity
@Table(name = "programme")
public class Programme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int entityId;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @OneToOne(mappedBy = "programme")
    private ProgrammeCredits credits;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    private String title;

    @Column(name = "sub_title")
    private String subTitle;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "episode_num")
    private String episodeNumber;

    @Column(name = "icon")
    private URL icon;


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getEntityId() {
        return entityId;
    }

    protected void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public String getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public URL getIcon() {
        return icon;
    }

    public void setIcon(URL icon) {
        this.icon = icon;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
