/******************************************************************
 *
 * Copyright 2017 Samsung Electronics All Rights Reserved.
 *
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 ******************************************************************/

package org.edgexfoundry.device.opcua.adapter.coredata;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.edgexfoundry.domain.core.Event;
import org.edgexfoundry.domain.core.Reading;

public class EventGenerator {

  /**
   * Create Reading <br>
   * Use {@link org.edgexfoundry.domain.core.Reading#Reading()} to generate reading instance
   * 
   * @param deviceName Name which matched with ValueDescriptor
   * @param value data of reading
   * @return created reading
   */
  private static Reading createReading(String deviceName, String value) {
    Reading reading = new Reading();
    // Guide2: Reading must has name which matched with ValueDescriptor
    // which posted in metadata DB.
    reading.setName(deviceName);

    // Guide3: Value can set with setValue(String) method.
    reading.setValue(value);
    return reading;
  }

  /**
   * Create list of Reading <br>
   * Use {@link #createReading(String, String)} to create Reading
   * 
   * @param deviceName Name which matched with ValueDescriptor
   * @param value data of reading
   * @return created list of Reading
   */
  private static List<Reading> createReadingList(String deviceName, String value) {
    List<Reading> readings = new ArrayList<>();
    readings.add(createReading(deviceName, value));
    return readings;
  }

  /**
   * Generate Event <br>
   * Use {@link org.edgexfoundry.domain.core.Event#Event(String, List)} to generate Event
   * 
   * @param name name of device which posted in metadata DB.
   * @param value data of reading
   * @return generated Event
   */
  public static Event generate(String name, String value) {
    if (name == null || name.isEmpty()) {
      return null;
    }
    // Guide1: To construct event, device identifier required.
    // device identifier can be name of device which posted in metadata DB.
    List<Reading> readingList = createReadingList(name, value);

    Event event = new Event(name, readingList);

    event.markPushed(new Timestamp(System.currentTimeMillis()).getTime());
    event.setDevice(name);
    event.setOrigin(new Timestamp(System.currentTimeMillis()).getTime());
    return event;
  }
}
