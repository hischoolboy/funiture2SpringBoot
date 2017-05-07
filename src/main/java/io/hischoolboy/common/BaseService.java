package io.hischoolboy.common;

/**
 * Service的基类，实现SelfAware接口。
 * 可以通过self()方法拿到spring容器中的service实例，从而拥有增强特性。
 * <p/>
 * 
 */
public abstract class BaseService<T> implements SelfAware<T> {

    private T self;

    @Override
    public T self() {
        if (self == null)
            self = (T) SpringHelper.popBean(getClass());
        return self;
    }
}
