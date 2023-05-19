package com.zybooks.dsaj.design;

/** Interface for objects that can be insured when shipped. */
public interface Insurable extends Sellable, Transportable {
    /**
     * Returns the insured value of the item, in cents.
     * @return the insured value of the item, in cents
     */
    public int insuredValue();
}
