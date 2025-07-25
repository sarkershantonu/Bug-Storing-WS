package org.automation.bug.ws.ws.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Created by shantonu on 12/18/16.
 */
@Entity
public class Bug {
    public Bug() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAttachmentPath() {
        return AttachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        AttachmentPath = attachmentPath;
    }

    public String getExceptions() {
        return exceptions;
    }

    public void setExceptions(String exceptions) {
        this.exceptions = exceptions;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFoundDateTime() {
        return foundDateTime;
    }

    public void setFoundDateTime(String foundDateTime) {
        this.foundDateTime = foundDateTime;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getServility() {
        return servility;
    }

    public void setServility(String servility) {
        this.servility = servility;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String summary;
    private String Description;
    private String AttachmentPath;
    private String exceptions;
    private String comments;
    private String foundDateTime;
    private String tags;
    private String priority;
    private String servility;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bug)) return false;

        Bug bug = (Bug) o;

        if (!getId().equals(bug.getId())) return false;
        if (!getTitle().equals(bug.getTitle())) return false;
        if (!getSummary().equals(bug.getSummary())) return false;
        if (!getDescription().equals(bug.getDescription())) return false;
        if (!getAttachmentPath().equals(bug.getAttachmentPath())) return false;
        if (!getExceptions().equals(bug.getExceptions())) return false;
        if (!getComments().equals(bug.getComments())) return false;
        if (!getFoundDateTime().equals(bug.getFoundDateTime())) return false;
        if (!getTags().equals(bug.getTags())) return false;
        if (!getPriority().equals(bug.getPriority())) return false;
        return getServility().equals(bug.getServility());
    }

    public boolean equalsByData(Object o) {
        Bug bug = (Bug) o;

        if (!getId().equals(bug.getId())) return false;
        if (!getTitle().equals(bug.getTitle())) return false;
        if (!getSummary().equals(bug.getSummary())) return false;
        if (!getDescription().equals(bug.getDescription())) return false;
        if (!getAttachmentPath().equals(bug.getAttachmentPath())) return false;
        if (!getExceptions().equals(bug.getExceptions())) return false;
        if (!getComments().equals(bug.getComments())) return false;
        if (!getFoundDateTime().equals(bug.getFoundDateTime())) return false;
        if (!getTags().equals(bug.getTags())) return false;
        if (!getPriority().equals(bug.getPriority())) return false;
        return getServility().equals(bug.getServility());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getSummary().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getAttachmentPath().hashCode();
        result = 31 * result + getExceptions().hashCode();
        result = 31 * result + getComments().hashCode();
        result = 31 * result + getFoundDateTime().hashCode();
        result = 31 * result + getTags().hashCode();
        result = 31 * result + getPriority().hashCode();
        result = 31 * result + getServility().hashCode();
        return result;
    }

    public String getJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }

}
