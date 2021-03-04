/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sulbasoft.business;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 *
 * @author M. S. Ali (CCS)
 */
@Data
@NoArgsConstructor
@ToString
public class Address {
   private String city;
   private String state;
   private String zipCode;
}
