package org.joensson.nasdvr.model;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;

@Entity
@Table(name = "programme")
public class Programme extends NasDvrEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @ManyToOne(cascade = CascadeType.ALL)
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

    @ManyToOne(cascade = CascadeType.ALL)
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

    public ProgrammeCredits getCredits() {
        return credits;
    }

    public void setCredits(ProgrammeCredits credits) {
        this.credits = credits;
    }

    //This field is used by the jdbc row mapper - rather than setting the Channel object, the foreign key is set
    @Transient
    private int channelId;

    //This field is used by the jdbc row mapper - rather than setting the Category object, the foreign key is set
    @Transient
    private int categoryId;


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

}
