package testJava.ordemservico.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import testJava.ordemservico.models.OrdemServico;
import testJava.ordemservico.repository.OrdemServicoRepository;

@Controller
public class OrdemServicoControler {
   
    @Autowired
    private OrdemServicoRepository er;

     

    @RequestMapping(value="/listaOrdensServico", method = RequestMethod.GET)
    public ModelAndView form() {
        //Ler todas as ordens de serviço para apresentar na tela listaOrdensServico
        Iterable<OrdemServico> ordensServico = this.er.findAll();
        ModelAndView mv = new ModelAndView("evento/listaOrdensServico");
        mv.addObject("ordensServico", ordensServico);
        return mv;
    }

 

    @RequestMapping(value="/criarOrdemServico", method = RequestMethod.POST)
    public String form(OrdemServico oS) {
       //Salvar OS no banco de dados
        int maior =0;
        //pegar o funcionario atual quando o sistema de login tiver funcionando
        oS.setFuncionario("0812038782");

	    Date date = new Date();
        oS.setData_inicio(date);
        oS.setStatus_os("Aberto");
        Iterable<OrdemServico> ordensServico = this.er.findAll();

        //Setar o ID da OS
        for (OrdemServico ordemServico : ordensServico) {
            if (maior < ordemServico.getCodigo()){
                maior=ordemServico.getCodigo();
            }
        }
        oS.setCodigo(maior+1);
        this.er.save(oS);

        //Redirecionar para a lista de OS
        return "redirect:/listaOrdensServico";
    }



    @RequestMapping(value="/criarOrdemServico", method = RequestMethod.GET)
    public String formCriarOrdemServico() {
        //tela de cadastro da ordem de serviço
        return "evento/criarOrdemServico";
    }

    @RequestMapping(value="/appOrdemServico", method = RequestMethod.GET)
    public String appOrdemServico() {
        //tela inicial da aplicação
        return "evento/appOrdemServico";
    }
}