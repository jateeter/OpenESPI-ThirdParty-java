/*
 * Copyright 2013 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.energyos.espi.thirdparty.web;

import org.energyos.espi.thirdparty.domain.BatchList;
import org.energyos.espi.thirdparty.domain.Routes;
import org.energyos.espi.thirdparty.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.bind.JAXBException;

@Controller
public class NotificationController extends BaseController {
    @Autowired
    private UpdateService updateService;

    @RequestMapping(value = Routes.ThirdPartyNotification, method = RequestMethod.POST)
    public void notification(BatchList batchList) throws JAXBException {
        for(String resourceURI : batchList.getResourceURIs()) {
            updateService.update(resourceURI);
        }
    }

    public void setUpdateService(UpdateService updateService) {
        this.updateService = updateService;
    }
}
