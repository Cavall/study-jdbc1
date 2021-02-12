package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	
			//Depois de criado o banco de dados e com o serviço mysql ativado 

			public static void main(String[] args) {
				// variavel para conectar o bd
				Connection conn = null;
				// variavel para buscar todos os departamentos ..consulta no bd
				Statement st = null;
				// variavel para guardar o resultado da consulta
				ResultSet rs = null;

				try {
					// a variavel conn vai receber a classe DB para conectar
					conn = DB.getConnection();
					// instanciando a variavel st
					st = conn.createStatement();
					// executando a consulta com st com a string sql:
					// st.executeQuery("select * from departament");
					// o resultado da consulta sera atribuido a variavel rs
					rs = st.executeQuery("select * from department");
					// para expor e imprimir os dados da consulta
					while (rs.next()) {
						System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
