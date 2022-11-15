package testJava.ordemservico.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import testJava.ordemservico.models.OrdemServico;
import testJava.ordemservico.models.alteracaoOS;
import testJava.ordemservico.repository.OrdemServicoRepository;
import testJava.ordemservico.repository.alteracaoOSRepository;


@Controller
public class alteracaoOSControler {


    @Autowired
    private alteracaoOSRepository er;

    @Autowired
    private OrdemServicoRepository era;


    @RequestMapping("alterarOS/{codigo}")
    public ModelAndView alterarOS(@PathVariable("codigo") Integer codigo){

        //Ler todas as alterações da OS em questão para apresentar na tela de alteração de OS 
        Iterable<alteracaoOS> oSs = this.er.findAllByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/alterarOS");
        mv.addObject("alteracaoOS", oSs);

        return mv;
    }

    @RequestMapping(value="alterarOS/{codigo}", method = RequestMethod.POST)
    public String form(alteracaoOS oS) {
       
        int maior_alt =0;
        int maior_id = 0;
        //pegar o funcionario atual quando tiver sistema de login
        oS.setFuncionario("0812038782");
	    Date date = new Date();
        oS.setData_alt(date);
        Iterable<alteracaoOS> altOSs = this.er.findAll();
        //setando aids de alteraçãos de OSs
        for (alteracaoOS altOS : altOSs) {
            if(maior_id<altOS.getId()){
                maior_id=altOS.getId();
            }
            if(altOS.getCodigo()==oS.getCodigo())
                if (maior_alt < altOS.getNum_alteracao()){
                    maior_alt=altOS.getNum_alteracao();
                }
        }
        //criar nova alteração da OS
        oS.setNum_alteracao(maior_alt+1);
        oS.setId(maior_id+1);
        this.er.save(oS);

        OrdemServico ordensServico = this.era.findByCodigo(oS.getCodigo());
        //setar data e status da alteração na OS original
        ordensServico.setData_fim(date);
        ordensServico.setStatus_os(oS.getStatus_os());
        this.era.save(ordensServico);

        return "redirect:/listaOrdensServico";
    }

}