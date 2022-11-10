package com.mustache.bbs.domain.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "reply")
@Getter
@Setter
public class Reply {
    @Id
    private String id;

}
