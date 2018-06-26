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

import pl.praktycznykoder.marvelapi.model.domain.Series;
import pl.praktycznykoder.marvelapi.model.repositories.Repository;
import pl.praktycznykoder.marvelapi.model.repositories.SeriesAbstractRepositoryImpl;

/**
 *
 * @author praktycznykoder.pl
 */
public class SeriesAbstractServiceImpl extends AbstractService<Series> {

    private final SeriesAbstractRepositoryImpl repository = 
            new SeriesAbstractRepositoryImpl();
    
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
        return Series.ORDERBY_PARAM_NAMES;
    }
    
    /**
     *
     * @return
     */
    public String[] getContains() {
        return Series.CONTAINS;
    }
    
    /**
     *
     * @return
     */
    public String[] getSeriesType() {
        return Series.SERIES_TYPES;
    }
}
