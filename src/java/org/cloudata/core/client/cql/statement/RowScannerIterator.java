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
package org.cloudata.core.client.cql.statement;

import java.io.IOException;

import org.cloudata.core.client.CTable;
import org.cloudata.core.client.Row;
import org.cloudata.core.client.scanner.TableScanner;


/**
 * @author jindolk
 *
 */
public class RowScannerIterator implements RowIterator {
  private TableScanner scanner;
  private Row lastRow;
  private String[] columns;
  private CTable ctable;
  
  public RowScannerIterator(CTable ctable, TableScanner scanner, String[] columns) throws IOException {
    this.scanner = scanner;
    this.lastRow = scanner.nextRow();
    this.columns = columns;
    this.ctable = ctable;
  }
  
  public CTable getCTable() {
    return this.ctable;
  }
  
  @Override
  public Row nextRow() throws IOException {
    Row result = lastRow;
    
    if(lastRow != null) {
      lastRow = scanner.nextRow();
    }
    return result;
  }

  @Override
  public boolean hasNext() throws IOException {
    return lastRow != null;
  }

  @Override
  public String[] getColumns() {
    return columns;
  }

  @Override
  public void close() throws IOException {
    scanner.close();
  }
}
