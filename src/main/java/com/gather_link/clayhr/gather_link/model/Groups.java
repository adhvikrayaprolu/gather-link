package com.gather_link.clayhr.gather_link.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "groups_table")
public class Groups {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;
	
	@Column(name = "group_name", nullable = false, length = 100)
    private String groupName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Users owner;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "member_count")
    private int memberCount;

    @Column(name = "post_count")
    private int postCount;
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }
    
    public int getMemberCount() {
        return memberCount;
    }
    
    public int getPostCount() {
        return postCount;
    }
}
