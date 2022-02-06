package com.fatihhernn.ticketservice.repository.elastic;

import com.fatihhernn.ticketservice.model.elastic.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel,String> {
}
