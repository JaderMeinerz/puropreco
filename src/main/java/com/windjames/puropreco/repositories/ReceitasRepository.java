package com.windjames.puropreco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.windjames.puropreco.entities.Receitas;
import com.windjames.puropreco.projection.ReceitasMinProjection;

public interface ReceitasRepository extends JpaRepository<Receitas, Long> {
    @Query(nativeQuery = true, value = """
        SELECT  tb_receitas.id_receitas, tb_receitas.ingrediente, tb_receitas.quantidade, tb_receitas.rendimento, tb_receitas.peso_unidade, tb_receitas.tempo_preparo ,tb_ingredientesreceitas.position
        FROM tb_receitas
        INNER JOIN tb_ingredientesreceitas ON tb_receitas.id = tb_ingredientesreceitas.id_receitas
        WHERE tb_ingredientesreceitas.list_id = :listId
        ORDER BY tb_ingredientesreceitas.position
            """)
    List <ReceitasMinProjection> searchByList (Long listId);
}
