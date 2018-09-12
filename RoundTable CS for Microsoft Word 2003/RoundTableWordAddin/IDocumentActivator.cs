using RoundTable;

namespace RoundTableWordAddin
{
	public interface IDocumentActivator
	{
		void ActivateDocument(Document document, ProjectServerConnection psc);
	}
}