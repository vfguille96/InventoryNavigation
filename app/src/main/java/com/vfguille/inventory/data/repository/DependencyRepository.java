package com.vfguille.inventory.data.repository;

import com.vfguille.inventory.data.model.Dependency;

import java.util.ArrayList;
import java.util.List;

public class DependencyRepository {
    private static DependencyRepository dependencyRepository;
    private List<Dependency> list;

    private DependencyRepository(){
        list = new ArrayList<>();
        initialize();
    }

    public static DependencyRepository getInstance(){
        if (dependencyRepository == null)
            dependencyRepository = new DependencyRepository();
        return dependencyRepository;
    }

    private void initialize() {
        list.add(new Dependency("Dependency1", "Dep.1", "Dep. descr.", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("Dependency1", "Dep.1", "Dep. descr.", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("Dependency1", "Dep.1", "Dep. descr.", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("Dependency1", "Dep.1", "Dep. descr.", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("Dependency1", "Dep.1", "Dep. descr.", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("Dependency1", "Dep.1", "Dep. descr.", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("Dependency1", "Dep.1", "Dep. descr.", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("Dependency1", "Dep.1", "Dep. descr.", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("Dependency1", "Dep.1", "Dep. descr.", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("Dependency1", "Dep.1", "Dep. descr.", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("Dependency1", "Dep.1", "Dep. descr.", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("Dependency1", "Dep.1", "Dep. descr.", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("Dependency1", "Dep.1", "Dep. descr.", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
    }

    public List<Dependency> getList() {
        return this.list;
    }
}
