/**
 * 
 */
package com.jdevnath.pozos;

/**
 * @author dev2014
 *
 */
public class BodyMassIndex {

	public Double calculateBMI(double weight, double height) {
		// TODO Auto-generated method stub
		try {
			return weight/(height*height);
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
		}
		return -1.0;
	}

}
