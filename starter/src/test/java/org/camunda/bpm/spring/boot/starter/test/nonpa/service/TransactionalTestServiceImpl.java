/*
 * Copyright © 2015-2018 camunda services GmbH and various authors (info@camunda.com)
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
package org.camunda.bpm.spring.boot.starter.test.nonpa.service;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.spring.boot.starter.test.nonpa.jpa.domain.TestEntity;
import org.camunda.bpm.spring.boot.starter.test.nonpa.jpa.repository.TestEntityRepository;
import org.camunda.bpm.spring.boot.starter.test.nonpa.service.TransactionalTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionalTestServiceImpl implements TransactionalTestService {

  @Autowired
  private TestEntityRepository testEntityRepository;

  @Autowired
  private RuntimeService runtimeService;

  @Override
  public ProcessInstance doOk() {
    TestEntity entity = new TestEntity();
    entity.setText("text");
    TestEntity testEntity = testEntityRepository.save(entity);
    Map<String, Object> variables = new HashMap<String, Object>();
    variables.put("test", testEntity);
    return runtimeService.startProcessInstanceByKey("TestProcess", variables);
  }

  @Override
  @Transactional(TxType.REQUIRES_NEW)
  public void doThrowing() {
    doOk();
    throw new IllegalStateException();
  }
}
