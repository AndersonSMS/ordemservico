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
        //alteracaoOS oS = this.er.findByCodigo(codigo);
        Iterable<alteracaoOS> oSs = this.er.findAllByCodigo(codigo);
        //int tam=0;
        //this.er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/alterarOS");
        //alteracaoOS ultAlteracao = new alteracaoOS();
        //for (alteracaoOS altOS : oSs) {
            //ultAlteracao.setStatus_os(altOS.getStatus_os());
        //}
        //ultAlteracao.setDescricao("");
        
        mv.addObject("alteracaoOS", oSs);
        //.addObject("ultAlteracao", ultAlteracao);
        return mv;
    }

    @RequestMapping(value="alterarOS/{codigo}", method = RequestMethod.POST)
    public String form(alteracaoOS oS) {
       
        int maior_alt =0;
        int maior_id = 0;
        //pegar o funcionario atual
        oS.setFuncionario("0812038782");
        //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
        oS.setData_alt(date);
        //oS.setStatus_os("Aberto");
        Iterable<alteracaoOS> altOSs = this.er.findAll();
        for (alteracaoOS altOS : altOSs) {
            if(maior_id<altOS.getId()){
                maior_id=altOS.getId();
            }
            if(altOS.getCodigo()==oS.getCodigo())
                if (maior_alt < altOS.getNum_alteracao()){
                    maior_alt=altOS.getNum_alteracao();
                }
        }
        oS.setNum_alteracao(maior_alt+1);
        oS.setId(maior_id+1);
        this.er.save(oS);

        OrdemServico ordensServico = this.era.findByCodigo(oS.getCodigo());
        //if(oS.getStatus_os()=="Finalizada"||oS.getStatus_os()=="Entregue"){
            ordensServico.setData_fim(date);
        //}
        ordensServico.setStatus_os(oS.getStatus_os());
        this.era.save(ordensServico);
        return "redirect:/listaOrdensServico";
    }

}