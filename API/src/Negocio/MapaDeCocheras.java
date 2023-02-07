package Negocio;

import java.util.Vector;

public class MapaDeCocheras {
	private static Vector<Cochera> cocheras;
	
	public MapaDeCocheras(){
		cocheras = new Vector<Cochera>();
	}
	
	public void agregarCochera(){
		Cochera c = new Cochera();
		cocheras.add(c);
	}
	
	@SuppressWarnings("null")
	public static Vector<Cochera> verificarEspacio(boolean auto)
	{
		Vector<Cochera> vec = null;
		if(auto){
			for(Cochera C:cocheras)
			{
				if(!C.getEstado()) //false = Disponible
				{
					vec.add(C);
					return vec;
				}
			}
		}
		else
		{
			for(Cochera C:cocheras)
			{
				if(!C.getEstado()) //false = Disponible
				{
					Cochera C2=(cocheras.elementAt(cocheras.indexOf(C)+1));
					
					if(!C2.getEstado() && (C.getPiso() == C2.getPiso()))
					{
						C.setEstado(true);
						C2.setEstado(true);						
						vec.add(C);
						vec.add(C2);
						return vec;
					}					
				}
			}
		}
		
		return null;
	}
	
	public static Cochera getUltimaCochera()
	{
		return cocheras.lastElement();
	}
}
