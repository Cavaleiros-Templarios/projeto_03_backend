package com.generation.projeto_03_backend.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;


@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springBlogPessoalOpenAPI() {
	    return new OpenAPI()
	        .info(new Info()
	            .title("Projeto CRM API")
	            .description(
	                "API desenvolvida como parte do projeto CRM\n" +
	                "- Cadastro de clientes\n" +
	                "- Atualização de dados\n" +
	                "- Exclusão de registros\n" +
	                "- Listagem de clientes\n"
	            )
	            .version("v1.0.0")
	            .license(new License()
	            	.name("Generation Brasil")
	                .url("https://brazil.generation.org/"))
	            .contact(new Contact()
	                .name("Grupo 3")
	                .url("https://allmylinks.com/grupo03") 
	                .email("")))
	        .externalDocs(new ExternalDocumentation()
	            .description("Repositório GitHub")
	            .url("https://github.com/Cavaleiros-Templarios/projeto_03_backend"));
	}

	@Bean
	OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {

		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
				apiResponses.addApiResponse("403", createApiResponse("Acesso Proibido!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));

			}));
		};
	}

	private ApiResponse createApiResponse(String message) {

		return new ApiResponse().description(message);

	}
}