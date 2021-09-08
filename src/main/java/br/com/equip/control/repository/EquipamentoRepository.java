package br.com.equip.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.equip.control.model.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

}
