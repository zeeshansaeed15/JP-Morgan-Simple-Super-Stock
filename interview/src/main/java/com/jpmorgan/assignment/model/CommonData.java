/**
 * 
 */
package com.jpmorgan.assignment.model;

import java.io.Serializable;

/**
 * @author Zeeshan Saeed
 *
 */
public class CommonData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			if ( !obj.getClass().isAssignableFrom(getClass()) && !getClass().isAssignableFrom(obj.getClass()) )
		        return false;
		}

		CommonData other = (CommonData) obj;
		if (this.id == null && other.id == null) 
			return super.equals(obj);
		
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}

		return true;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}