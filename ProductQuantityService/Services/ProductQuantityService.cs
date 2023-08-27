using Grpc.Core;

namespace ProductQuantityService.Services
{
    
    public class ProductQuantitySvc : ProductQuantity.ProductQuantityBase
    {

        public override Task<QuantityReply> getProductQuantity(QuantityRequest request, ServerCallContext context)
        {
            return Task.FromResult(new QuantityReply
            {
                Quantity = 123
            });
        }
    }
}