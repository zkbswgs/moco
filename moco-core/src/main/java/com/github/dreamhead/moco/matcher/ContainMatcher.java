package com.github.dreamhead.moco.matcher;

import com.github.dreamhead.moco.RequestExtractor;
import com.github.dreamhead.moco.RequestMatcher;
import com.github.dreamhead.moco.resource.Resource;
import com.google.common.base.Predicate;

public class ContainMatcher<T> extends AbstractOperatorMatcher<T> {
    public ContainMatcher(RequestExtractor<T> extractor, final Resource expected) {
        super(extractor, expected, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.contains(new String(expected.readFor(null)));
            }
        });
    }

    @Override
    protected RequestMatcher newMatcher(RequestExtractor<T> extractor, Resource resource) {
        return new ContainMatcher<T>(extractor, resource);
    }
}
