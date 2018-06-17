package com.outland.packets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHelloWorld implements IMessage
{

	String message = "";
	int length = 0;
	
	public PacketHelloWorld()
	{
		
	}
	
	public PacketHelloWorld(String _message)
	{
		message = _message;
		length = message.length();
	}
	
	@Override
	public void fromBytes(ByteBuf _buf) 
	{
		message = "";
		length = _buf.readInt();
		
		for(int i = 0; i < length; i++)
		{
			message += _buf.readChar();
		}
		

	}

	@Override
	public void toBytes(ByteBuf _buf) 
	{
		_buf.writeInt(length);
		
		for(int i = 0; i < length; i++)
		{
			_buf.writeChar((int)message.toCharArray()[i]);
		}
		
	}
	
	public static class Handler implements IMessageHandler<PacketHelloWorld, IMessage> 
    {
		@Override
        public IMessage onMessage(PacketHelloWorld message, MessageContext ctx) 
        {
			if(ctx.side == Side.SERVER)
			{
				System.out.println("Recieved string:");
				System.out.println(message.message);
			}
			return null;
        }
    }


}
