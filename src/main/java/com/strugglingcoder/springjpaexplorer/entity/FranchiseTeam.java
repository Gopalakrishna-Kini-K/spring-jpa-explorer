package com.strugglingcoder.springjpaexplorer.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Kini on 31-Jan-18.
 */
@Table(name="franchise_team")
@Entity
public class FranchiseTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name="native",strategy = "native")    // refer https://vladmihalcea.com/9-high-performance-tips-when-using-mysql-with-jpa-and-hibernate/
    private Long id;

    private String Country;

    private String leagueName;

    private String teamName;

    private String captainName;
}
