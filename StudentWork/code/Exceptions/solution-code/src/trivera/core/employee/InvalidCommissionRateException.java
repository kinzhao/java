package trivera.core.employee;

/**
 * <p>
 * This component and its source code representation are copyright protected
 * and proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and
 * evaluation purposes only. No part of this component or its source code
 * may be sold, transferred, or publicly posted, nor may it be used in a
 * commercial or production environment, without the express written consent
 * of Trivera Technologies, LLC
 *
 * Copyright (c) 2020 Trivera Technologies, LLC.
 * http://www.triveratech.com   
 * </p>
 * @author Trivera Technologies Tech Team.
 */


public class InvalidCommissionRateException extends Exception {
     private double maximumRate;
    /**
   *
   */
  private static final long serialVersionUID = 5690296628688370949L;

  public InvalidCommissionRateException(String msg, double maxRate) {
        super(msg);
        this.maximumRate = maxRate;
    }

    @Override
    public String toString() {
        return "Requested commission rate is not allowed as maximum rate is: " + maximumRate;
    }
}