package de.muellerj;

import lombok.EqualsAndHashCode;

public class EqualsAndHashCodeExampleExplizitEquals {

	private String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
	   @java.lang.SuppressWarnings(value = "all")
	    public boolean equals(final java.lang.Object o) {
	        if (o == this) return true;
	        if (!(o instanceof EqualsAndHashCodeExampleExplizitEquals)) return false;
	        final EqualsAndHashCodeExampleExplizitEquals other = (EqualsAndHashCodeExampleExplizitEquals)o;
	        if (!other.canEqual((java.lang.Object)this)) return false;
	        final java.lang.Object this$property = this.getProperty();
	        final java.lang.Object other$property = other.getProperty();
	        if (this$property == null ? other$property != null : !this$property.equals(other$property)) return false;
	        return true;
	    }
	    
	    @java.lang.SuppressWarnings(value = "all")
	    protected boolean canEqual(final java.lang.Object other) {
	        return other instanceof EqualsAndHashCodeExampleExplizitEquals;
	    }
	    
	    @java.lang.Override
	    @java.lang.SuppressWarnings(value = "all")
	    public int hashCode() {
	        final int PRIME = 59;
	        int result = 1;
	        final java.lang.Object $property = this.getProperty();
	        result = result * PRIME + ($property == null ? 43 : $property.hashCode());
	        return result;
	    }
}
