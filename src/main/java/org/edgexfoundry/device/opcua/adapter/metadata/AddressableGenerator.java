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

package org.edgexfoundry.device.opcua.adapter.metadata;

import org.edgexfoundry.domain.meta.Addressable;
import org.edgexfoundry.domain.meta.Protocol;

public class AddressableGenerator {

  /**
   * construct AddressableGenerator <br>
   */
  private AddressableGenerator() {}

  /**
   * generate Addressable <br>
   * Use
   * {@link org.edgexfoundry.domain.meta.Addressable#Addressable(String, Protocol, String, String, int)}
   * to generate Addressable
   * 
   * @param name Name which matched with Device
   * @return created Addressable
   */
  public static Addressable generate(String name) {
    if (name == null || name.isEmpty()) {
      return null;
    }
    Addressable addressable =
        new Addressable(name, Protocol.TCP, OPCUADefaultMetaData.ADDRESS.getValue(),
            OPCUADefaultMetaData.PATH.getValue(), OPCUADefaultMetaData.ADDRESSABLE_PORT);
    return addressable;
  }
}
