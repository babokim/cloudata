/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cloudata.core.client.cql.element;

import java.io.IOException;

import org.cloudata.core.client.Row;
import org.cloudata.core.client.RowFilter;
import org.cloudata.core.common.conf.CloudataConf;



/**
 * @author jindolk
 *
 */
public class LikeExpression implements WhereExpressionElement {
  SingleColumnElement column;
  StringLiteral value;

  public void setColumn(SingleColumnElement column) {
    this.column = column;
  }
  
  public void setValue(StringLiteral value) {
    this.value = value;
  }

  @Override
  public String getQuery(CloudataConf conf) {
    return column.getQuery(conf) + " LIKE " + value.getQuery(conf);
  }

  @Override
  public void initFilter(RowFilter rowFilter) throws IOException {
    if(column.isRowKey()) {
      Row.Key rowKey = new Row.Key(value.getValue());
      rowFilter.setValue(rowKey, rowKey, RowFilter.OP_LIKE);
    } else {
      throw new IOException("Not support column's like expression");
    }
  }
}
