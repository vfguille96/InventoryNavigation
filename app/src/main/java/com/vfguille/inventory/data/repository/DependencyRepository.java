package com.vfguille.inventory.data.repository;

import com.vfguille.inventory.data.model.Dependency;

import java.util.ArrayList;
import java.util.List;

public class DependencyRepository {
    private static DependencyRepository dependencyRepository;
    private List<Dependency> list;

    // Se inicializan en el bloque static las propiedades de la clase. Se evita comprobar si es null.
    static {
        dependencyRepository = new DependencyRepository();
    }

    // Constructor privado porque sólo existe un objeto Repository.
    private DependencyRepository(){
        list = new ArrayList<>();
        initialize();
    }

    public static DependencyRepository getInstance(){
        return dependencyRepository;
    }

    private void initialize() {
        list.add(new Dependency("2º Ciclo Formativo Grado Superior", "2CFGS", "Aula informática", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("2º Ciclo Formativo Grado Superior", "2CFGS", "Cafetería", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("1º Ciclo Formativo Grado Superior", "1CFGS", "Aula informática", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("1º Ciclo Formativo Grado Superior", "1CFGS", "Aula de convivencia", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("1º Ciclo Formativo Grado Medio", "1CFGM", "Aula informática", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("2º Ciclo Formativo Grado Medio", "2CFGM", "Aula informática", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("4º ESO", "4ESO", "Aula informática", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("3º ESO", "3ESO", "Aula informática", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("2º ESO", "2ESO", "Aula informática", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));
        list.add(new Dependency("1º ESO", "1ESO", "Aula informática", "https://images.squarespace-cdn.com/content/v1/549f45d6e4b037c1971053fd/1429331411211-EJKOTLKYFMKLFNDCX8IE/ke17ZwdGBToddI8pDm48kAt72yGFwHZjoxtmj75n0VMUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dvp1wM0jvciobd5mvjBb-PkjbbxSYDSdt-BIyUswy_5eG6v6ULRah83RgHXAWD5lbQ/image-asset.jpeg?format=750w"));

    }

    public List<Dependency> getList() {
        return this.list;
    }
}
