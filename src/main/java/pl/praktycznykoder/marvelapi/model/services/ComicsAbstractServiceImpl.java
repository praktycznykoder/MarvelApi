/*
 * Copyright (C) 2018 praktycznykoder.pl
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package pl.praktycznykoder.marvelapi.model.services;

import pl.praktycznykoder.marvelapi.model.domain.Comics;
import pl.praktycznykoder.marvelapi.model.repositories.ComicsAbstractRepositoryImpl;
import pl.praktycznykoder.marvelapi.model.repositories.Repository;

/**
 *
 * @author praktycznykoder.pl
 */
public class ComicsAbstractServiceImpl 
        extends AbstractService<Comics> {

    private final ComicsAbstractRepositoryImpl repository = 
            new ComicsAbstractRepositoryImpl();
    
    /**
     *
     * @return
     */
    @Override
    protected Repository getRepository() {
        return repository;
    }

    /**
     *
     * @return
     */
    @Override
    public String[] getOrderByParamNodes() {
        return Comics.ORDERBY_PARAM_NAMES;
    }
    
    /**
     *
     * @return
     */
    public String[] getFormatParamNodes() {
        return Comics.FORMAT_PARAM_NAMES;
    }
    
    /**
     *
     * @return
     */
    public String[] getFormatTypeParamNodes() {
        return Comics.FORMAT_TYPE_PARAM_NAMES;
    }
    
    /**
     *
     * @return
     */
    public String[] getDateDescriptorParamNodes() {
        return Comics.DATE_DESCRIPTOR_PARAM_NAMES;
    }
    
}
