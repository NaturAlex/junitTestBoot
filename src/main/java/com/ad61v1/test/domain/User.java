package com.ad61v1.test.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zhangtengchen
 * @Date: 2020/2/24 17:00
 */
@Data
public class User implements Serializable {

	private Long id;

	private String name;
}
