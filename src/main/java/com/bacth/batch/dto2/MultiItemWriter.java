package com.bacth.batch.dto2;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class MultiItemWriter <T> implements ItemWriter<T> {

    private List<ItemWriter<? super T>> delegates;

    public MultiItemWriter(List<ItemWriter<? super T>> delegates) {
        this.delegates = delegates;
    }

    @Override
    public void write(List<? extends T> items) throws Exception {
        for (ItemWriter<? super T> delegate : delegates) {
            delegate.write(items);
        }
    }
}