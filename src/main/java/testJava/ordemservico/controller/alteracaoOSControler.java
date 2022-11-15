package testJava.ordemservico.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import testJava.ordemservico.models.alteracaoOS;
import testJava.ordemservico.repository.alteracaoOSRepository;


@Controller
public class alteracaoOSControler {


    @Autowired
    private alteracaoOSRepository er;


    @RequestMapping("alterarOS/{codigo}")
    public ModelAndView alterarOS(@PathVariable("codigo") Integer codigo){
        alteracaoOS oS = this.er.findByCodigo(codigo);
        //this.er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/alterarOS");
        mv.addObject("alteracaoOS", oS);
        return mv;
    }

    @RequestMapping(value="/criarOrdemServico", method = RequestMethod.POST)
    public String form(alteracaoOS oS) {
       
        int maior =0;
        //pegar o funcionario atual
        oS.setFuncionario("0812038782");
        //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
        oS.setData_alt(date);
        oS.setStatus_os("Aberto");
        Iterable<alteracaoOS> ordensServico = this.er.findAll();
        for (alteracaoOS ordemServico : ordensServico) {
            if (maior < ordemServico.getCodigo()){
                maior=ordemServico.getCodigo();
            }
        }
        oS.setCodigo(maior+1);
        this.er.save(oS);
        return "redirect:/listaOrdensServico";
    }

}