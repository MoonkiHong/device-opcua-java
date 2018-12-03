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

public class DeviceObjectAttributeInfo {
  final private String providerKey;
  private String dataType;

  public static class Builder {
    final private String providerKey;
    private String dataType;

    /**
     * DeviceObjectAttributeInfo Builder
     * 
     * @param providerKey key of opcua client provider
     */
    public Builder(String providerKey) {
      if (null != providerKey) {
        this.providerKey = providerKey.replace(OPCUADefaultMetaData.AFTER_REPLACE_WORD,
            OPCUADefaultMetaData.BEFORE_REPLACE_WORD);
      } else {
        this.providerKey = providerKey;
      }
    }

    /**
     * Set DataType of DeviceObjectAttributeInfo
     * 
     * @param dataType dataType of DeviceObjectAttributeInfo
     * @return Builder
     */
    public Builder setDataType(String dataType) {
      this.dataType = dataType;
      return this;
    }

    /**
     * create DeviceObjectAttributeInfo instance (builder)
     * 
     * @return DeviceObjectAttributeInfo instance
     */
    public DeviceObjectAttributeInfo build() {
      return new DeviceObjectAttributeInfo(this);
    }
  }

  /**
   * construct DeviceObjectAttributeInfo
   * 
   * @param builder Builder of DeviceObjectAttributeInfo
   */
  DeviceObjectAttributeInfo(Builder builder) {
    this.providerKey = builder.providerKey;
    this.dataType = builder.dataType;
  }

  /**
   * Get ProviderKey of DeviceObjectAttributeInfo 
   * 
   * @return providerkey of DeviceObjectAttributeInfo
   */
  public String getProviderKey() {
    return providerKey;
  }

  /**
   * Get DataType of DeviceObjectAttributeInfo 
   * 
   * @return DataType of DeviceObjectAttributeInfo
   */
  public String getDataType() {
    return dataType;
  }
}
