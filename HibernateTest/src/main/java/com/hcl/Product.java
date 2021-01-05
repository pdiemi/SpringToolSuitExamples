package com.hcl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="product")
public class Product {

	@Id
	@Column(name="productid")
	private int prdId;
	@Column(name="productname")
	private String prdName;
	@Column(name="productprice")
	private double prdPrice;

}
