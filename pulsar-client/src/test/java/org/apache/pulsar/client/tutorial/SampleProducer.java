/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pulsar.client.tutorial;

import java.io.IOException;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

public class SampleProducer {
    public static void main(String[] args) throws PulsarClientException, InterruptedException, IOException {
        PulsarClient client = PulsarClient.builder().serviceUrl("http://localhost:6650").build();

        Producer<byte[]> producer = client.newProducer().topic("persistent://my-property/use/my-ns/my-topic").create();

        for (int i = 0; i < 10; i++) {
            producer.send("my-message".getBytes());
        }

        client.close();
    }
}
