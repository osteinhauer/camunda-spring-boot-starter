/*
 * Copyright © 2015-2019 camunda services GmbH and various authors (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.spring.boot.starter.property;

import static org.camunda.bpm.spring.boot.starter.property.CamundaBpmProperties.joinOn;

/**
 * Properties controlling spring eventing.
 */
public class EventingProperty {

  /**
   * Controls events of execution listener.
   */
  private boolean execution = true;
  /**
   * Controls events of task listener.
   */
  private boolean task = true;
  /**
   * Controls events of history handler.
   */
  private boolean history = true;

  public boolean isExecution() {
    return execution;
  }

  public void setExecution(boolean execution) {
    this.execution = execution;
  }

  public boolean isTask() {
    return task;
  }

  public void setTask(boolean task) {
    this.task = task;
  }

  public boolean isHistory() {
    return history;
  }

  public void setHistory(boolean history) {
    this.history = history;
  }

  @Override
  public String toString() {
    return joinOn(this.getClass())
      .add("execution=" + execution)
      .add("task=" + task)
      .add("history=" + history)
      .toString();
  }
}
